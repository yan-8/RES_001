package io.swagger.petstore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@JsonPropertyOrder({"petId", "category", "name", "photoUrls", "tags", "status"})
public class Pet {
    @JsonProperty("id") private int petId;
    private Category category;
    private String name;
    private String[] photoUrls;
    private List<Tag> tags;
    private String status;

    public Pet() {
    }

    public Pet(int petId, Category category, String name, String[] photoUrls, List<Tag> tags, String status) {
        this.petId = petId;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}