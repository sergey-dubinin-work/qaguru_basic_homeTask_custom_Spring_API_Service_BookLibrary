package guru.qa.booklibrary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class ErrorModel {
    private String timestamp;
    private Integer status;
    private String error;
    private String path;
}
