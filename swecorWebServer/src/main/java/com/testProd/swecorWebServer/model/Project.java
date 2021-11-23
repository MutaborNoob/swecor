package com.testProd.swecorWebServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "project", fetch = FetchType.EAGER)
    private List<Device> devices;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public void addDeviceToProject(Device device){
        if (devices == null){
            devices = new ArrayList<>();
        }
        devices.add(device);
        device.setProject(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
