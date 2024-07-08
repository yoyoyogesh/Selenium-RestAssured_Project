package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersPojo
{
    private String name;
    private String id;
    private String job;
    private String createdAt;

    public UsersPojo(String name, String id, String job, String createdAt)
    {
        this.name = name;
        this.id = id;
        this.job = job;
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Job")
    public String getJob() {
        return job;
    }

    @JsonProperty("CreatedAT")
    public String getCreatedAt() {
        return createdAt;
    }



}
