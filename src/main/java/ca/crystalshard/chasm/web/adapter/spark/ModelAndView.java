package ca.crystalshard.chasm.web.adapter.spark;

public class ModelAndView extends spark.ModelAndView {

    public ModelAndView(Object model, String viewName) {
        super(model, "views/" + viewName);
    }
}
