package digital.paisley.embryo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributesMap {
	
	@JsonProperty(value = "id")
	private String id;

}