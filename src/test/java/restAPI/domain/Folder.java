//Creating like a little database for one Folder

package restAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // if it finds what we didn't set to save (as name and id), it will ignore

public class Folder {
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    public void setName(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(final String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
