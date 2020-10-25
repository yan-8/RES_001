package io.swagger.petstore.api.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.petstore.api.entity.Category;
import io.swagger.petstore.api.entity.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PetResponse {
    @JsonProperty("id") private long petId;
    private Category category;
    @JsonProperty("name") private String petName;
    private String[] photoUrls;
    private List<Tag> tags;
    @JsonProperty("status") private String petStatus;
}