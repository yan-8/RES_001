package io.swagger.petstore.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@JsonPropertyOrder({"petId", "category", "petName", "photoUrls", "tags", "petStatus"})
public class Pet {
    @JsonProperty("id") private int petId;
    private Category category;
    @JsonProperty("name") private String petName;
    private String[] photoUrls;
    private List<Tag> tags;
    @JsonProperty("status") private String petStatus;

    public Pet() {
    }

    public Pet(int petId, Category category, String petName, String[] photoUrls, List<Tag> tags, String petStatus) {
        this.petId = petId;
        this.category = category;
        this.petName = petName;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.petStatus = petStatus;
    }
}