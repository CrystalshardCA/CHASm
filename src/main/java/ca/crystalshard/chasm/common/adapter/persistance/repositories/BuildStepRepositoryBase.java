package ca.crystalshard.chasm.common.adapter.persistance.repositories;

import ca.crystalshard.chasm.common.domain.BuildStep;
import ca.crystalshard.chasm.common.domain.BuildType;
import ca.crystalshard.chasm.common.domain.identifier.BuildStepId;
import ca.crystalshard.chasm.common.domain.identifier.JobId;
import ca.crystalshard.chasm.common.domain.persistance.repositories.BuildStepRepository;
import ca.crystalshard.chasm.common.adapter.persistance.Storage;
import ca.crystalshard.chasm.common.adapter.persistance.StorageConnection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuildStepRepositoryBase implements BuildStepRepository {
    protected String retrieveQuery;
    protected String deleteQuery;
    protected String insertQuery;
    protected String updateQuery;

    private Storage storage;

    public BuildStepRepositoryBase(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Optional<BuildStep> getBuildStep(BuildStepId buildStepId) {
        try (StorageConnection con = storage.open()) {
            BuildStepDto buildStepDto = con.createQuery(String.format("%s AND id = :id", retrieveQuery))
                    .addParameter("id", buildStepId.getId())
                    .executeAndFetchFirst(BuildStepDto.class);

            return buildStepDto != null
                    ? Optional.of(toBuildStep(buildStepDto))
                    : Optional.empty();
        }
        catch (Exception e) {
            throw new RuntimeException(String.format("Failed to retrieve build step with id: %s", buildStepId.toString()), e);
        }
    }

    @Override
    public BuildStepId saveBuildStep(BuildStep buildStep) {
        try (StorageConnection con = storage.open()) {
            Integer buildStepId = con.createQuery(insertQuery, true)
                    .addParameter("name", buildStep.getName())
                    .addParameter("jobId", buildStep.getJobId().getId())
                    .addParameter("buildTypeId", buildStep.getBuildType().getId())
                    .addParameter("orderValue", buildStep.getOrderValue())
                    .addParameter("isDisabled", buildStep.isDisabled() ? 1 : 0)
                    .executeUpdateWithKey(Integer.class);

            return BuildStepId.of(buildStepId);
        }
        catch (Exception e) {
            String exceptionMessage = String.format("Unable to save build step: %s", buildStep.getName());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    @Override
    public void updateBuildStep(BuildStepId id, BuildStep buildStep) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(updateQuery, false)
                    .addParameter("name", buildStep.getName())
                    .addParameter("jobId", buildStep.getJobId().getId())
                    .addParameter("buildTypeId", buildStep.getBuildType().getId())
                    .addParameter("orderValue", buildStep.getOrderValue())
                    .addParameter("isDisabled", buildStep.isDisabled() ? 1 : 0)
                    .addParameter("id", id.getId())
                    .executeUpdate();
        }
        catch (Exception e) {
            String exceptionMessage = String.format("Unable to update build step id: %s", id.getId());
            throw new UnableToSaveException(exceptionMessage, e);
        }
    }

    @Override
    public void deleteBuildStep(BuildStepId id) {
        try (StorageConnection con = storage.open()) {
            con.createQuery(deleteQuery)
                    .addParameter("id", id.getId())
                    .executeUpdate();
        }
    }

    @Override
    public List<BuildStep> getAllBuildStepsForJob(JobId jobId) {
        try (StorageConnection con = storage.open()) {
            return con.createQuery(retrieveQuery)
                    .executeAndFetch(BuildStepDto.class)
                    .stream().map(this::toBuildStep).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve build steps", e);
        }
    }

    private BuildStep toBuildStep(BuildStepDto buildStepDto) {
        return new BuildStep(
                BuildStepId.of(buildStepDto.id),
                buildStepDto.name,
                JobId.of(buildStepDto.jobId),
                BuildType.of(buildStepDto.buildTypeId),
                buildStepDto.orderValue,
                buildStepDto.isDisabled,
                buildStepDto.createdDateUtc,
                buildStepDto.updatedDateUtc,
                buildStepDto.deletedDateUtc
        );
    }

    private class BuildStepDto {
        int id;
        String name;
        int jobId;
        int buildTypeId;
        int orderValue;
        boolean isDisabled;
        String createdDateUtc;
        String updatedDateUtc;
        String deletedDateUtc;
    }
}