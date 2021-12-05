package bg.softuni.weedinfplanner.model.view;

public class IncludedAttributeViewModel {
    private Long id;
    private String attribute;

    public IncludedAttributeViewModel() {
    }

    public Long getId() {
        return id;
    }

    public IncludedAttributeViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAttribute() {
        return attribute;
    }

    public IncludedAttributeViewModel setAttribute(String attribute) {
        this.attribute = attribute;
        return this;
    }
}
