package com.stackroute.userservice.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about the Users. ")
@Entity
public class User {
    @Id
    @ApiModelProperty(notes = "id of the user")
    private long id;
    @ApiModelProperty(notes = "name of the user")
    private String  name;
    @ApiModelProperty(notes = "password of the user")
    private String  password;
    @ApiModelProperty(notes = "username date of the user")
    private String  username;
}
