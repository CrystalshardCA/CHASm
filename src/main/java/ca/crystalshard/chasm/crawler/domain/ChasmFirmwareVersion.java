package ca.crystalshard.chasm.crawler.domain;

public class ChasmFirmwareVersion {
    private int major;
    private int minor;
    private int revision;
    private int build;

    private ChasmFirmwareVersion(int major, int minor) {
        this(major, minor, 0, 0);
    }

    private ChasmFirmwareVersion(int major, int minor, int revision) {
        this(major, minor, revision, 0);
    }

    private ChasmFirmwareVersion(int major, int minor, int revision, int build) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
        this.build = build;
    }

    public static ChasmFirmwareVersion of(String version) {
        String[] items = version.split(".");
        if (items.length == 4) {
            return new ChasmFirmwareVersion(
                    Integer.parseInt(items[0]),
                    Integer.parseInt(items[1]),
                    Integer.parseInt(items[2]),
                    Integer.parseInt(items[3]));
        } else if (items.length == 3) {
            return new ChasmFirmwareVersion(
                    Integer.parseInt(items[0]),
                    Integer.parseInt(items[1]),
                    Integer.parseInt(items[2]));
        } else if (items.length == 2) {
            return new ChasmFirmwareVersion(
                    Integer.parseInt(items[0]),
                    Integer.parseInt(items[1]));
        } else {
            throw new UnableToParseVersionStringException(
                    String.format("Attempted to parse malformed version string: %s", version));
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getRevision() {
        return revision;
    }

    public int getBuild() {
        return build;
    }
}
