package restAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Task {

        @JsonProperty("id")
        private String idT;
        @JsonProperty("name")
        private String nameT;
        @JsonProperty("folder_id")
        private String folder_id;
        @JsonProperty("list_id")
        private String list_id;


        public void setNameT(final String nameT){this.nameT = nameT;}
        public String getNameT(){return nameT;}

        public void setIdT(final String idT){ this.idT = idT;    }
        public String getIdT(){ return idT;}

        public void setFolderId(final String folder_id){ this.folder_id = folder_id;}
        public String getFolderId(){return folder_id;}

        public void setListId(final String folder_id){ this.list_id = list_id;}
        public String getListId(){return list_id;}


}

