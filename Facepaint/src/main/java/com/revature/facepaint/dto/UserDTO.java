package com.revature.facepaint.dto;



import java.util.Objects;

import com.revature.facepaint.model.Role;
import com.revature.facepaint.model.User;

public class UserDTO {
    private int id;
    private String username;
    private Role role;
    private String imageId;

    public UserDTO(){
        super();
    }

    public UserDTO(User u){
        id = u.getId();
        username = u.getUsername();
        role = u.getRole();
        imageId = u.getImageID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && username.equals(userDTO.username) && role == userDTO.role && Objects.equals(imageId, userDTO.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role, imageId);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
