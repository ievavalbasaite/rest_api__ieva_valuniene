package restAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class List {

    @JsonProperty("id")
    private String idL;
    @JsonProperty("name")
    private String nameL;
    @JsonProperty("folder_id")
    private String folder_id;

    public void setNameL(final String nameL){this.nameL = nameL;}
    public String getNameL(){return nameL;}

    public void setIdL(final String idL){ this.idL = idL;    }
    public String getIdL(){ return idL;}

    public void setFolderId(final String folder_id){ this.folder_id = folder_id;}
    public String getFolderId(){return folder_id;}

}
