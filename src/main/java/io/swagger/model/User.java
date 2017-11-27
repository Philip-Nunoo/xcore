package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

 
public class User   {
     @JsonProperty("message")
    private String message;
     
    @JsonProperty("username")
    private String username = null;

    @JsonProperty("branch")
    private String branch = null;

    @JsonProperty("sessionId")
    private String sessionId = null;

    @JsonProperty("hostname")
    private String hostname = null;

    @JsonProperty("machineIp")
    private String machineIp = null;

    @JsonProperty("transEnq")
    private String transEnq = null;

    @JsonProperty("department")
    private String department = null;

    @JsonProperty("ac")
    private String ac = null;

    @JsonProperty("subBranch")
    private String subBranch = null;

    @JsonProperty("employeeId")
    private String employeeId = null;
    
    @JsonProperty("loginCode")
    private String loginCode = null;

    @JsonProperty("postDate")
    private String postDate;
    
    @JsonProperty("brDesc")
    private String brDesc = null;
    
     @JsonProperty("fullName")
    private String fullName = null;

    public User username(String username) {
      this.username = username;
      return this;
    }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBrDesc() {
        return brDesc;
    }

    public void setBrDesc(String brDesc) {
        this.brDesc = brDesc;
    }

  public User branch(String branch) {
    this.branch = branch;
    return this;
  }

   /**
   * Get branch
   * @return branch
  **/
  @ApiModelProperty(value = "")


  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public User sessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

   /**
   * Get sessionId
   * @return sessionId
  **/
  @ApiModelProperty(value = "")


  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public User hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

   /**
   * Get hostname
   * @return hostname
  **/
  @ApiModelProperty(value = "")


  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public User machineIp(String machineIp) {
    this.machineIp = machineIp;
    return this;
  }

   /**
   * Get machineIp
   * @return machineIp
  **/
  @ApiModelProperty(value = "")


  public String getMachineIp() {
    return machineIp;
  }

  public void setMachineIp(String machineIp) {
    this.machineIp = machineIp;
  }

  public User transEnq(String transEnq) {
    this.transEnq = transEnq;
    return this;
  }

   /**
   * Get transEnq
   * @return transEnq
  **/
  @ApiModelProperty(value = "")


  public String getTransEnq() {
    return transEnq;
  }

  public void setTransEnq(String transEnq) {
    this.transEnq = transEnq;
  }

  public User department(String department) {
    this.department = department;
    return this;
  }

   /**
   * Get department
   * @return department
  **/
  @ApiModelProperty(value = "")


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public User ac(String ac) {
    this.ac = ac;
    return this;
  }

   /**
   * Get ac
   * @return ac
  **/
  @ApiModelProperty(value = "")


  public String getAc() {
    return ac;
  }

  public void setAc(String ac) {
    this.ac = ac;
  }

  public User subBranch(String subBranch) {
    this.subBranch = subBranch;
    return this;
  }

   /**
   * Get subBranch
   * @return subBranch
  **/
  @ApiModelProperty(value = "")


  public String getSubBranch() {
    return subBranch;
  }

  public void setSubBranch(String subBranch) {
    this.subBranch = subBranch;
  }

  public User employeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @ApiModelProperty(value = "")


  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.username, user.username) &&
        Objects.equals(this.branch, user.branch) &&
        Objects.equals(this.sessionId, user.sessionId) &&
        Objects.equals(this.hostname, user.hostname) &&
        Objects.equals(this.machineIp, user.machineIp) &&
        Objects.equals(this.transEnq, user.transEnq) &&
        Objects.equals(this.department, user.department) &&
        Objects.equals(this.ac, user.ac) &&
        Objects.equals(this.subBranch, user.subBranch) &&
        Objects.equals(this.employeeId, user.employeeId);
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.message);
        hash = 79 * hash + Objects.hashCode(this.username);
        hash = 79 * hash + Objects.hashCode(this.branch);
        hash = 79 * hash + Objects.hashCode(this.sessionId);
        hash = 79 * hash + Objects.hashCode(this.hostname);
        hash = 79 * hash + Objects.hashCode(this.machineIp);
        hash = 79 * hash + Objects.hashCode(this.transEnq);
        hash = 79 * hash + Objects.hashCode(this.department);
        hash = 79 * hash + Objects.hashCode(this.ac);
        hash = 79 * hash + Objects.hashCode(this.subBranch);
        hash = 79 * hash + Objects.hashCode(this.employeeId);
        hash = 79 * hash + Objects.hashCode(this.loginCode);
        hash = 79 * hash + Objects.hashCode(this.postDate);
        hash = 79 * hash + Objects.hashCode(this.brDesc);
        hash = 79 * hash + Objects.hashCode(this.fullName);
        return hash;
    }

 

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
    sb.append("    machineIp: ").append(toIndentedString(machineIp)).append("\n");
    sb.append("    transEnq: ").append(toIndentedString(transEnq)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    ac: ").append(toIndentedString(ac)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    subBranch: ").append(toIndentedString(subBranch)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    loginCode: ").append(toIndentedString(loginCode)).append("\n");
    sb.append("    postDate: ").append(toIndentedString(postDate)).append("\n");
    sb.append("    brDesc: ").append(toIndentedString(brDesc)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
    private String toIndentedString(java.lang.Object o) {
      if (o == null) {
        return "null";
      }
      return o.toString().replace("\n", "\n    ");
    }

    public void setMessage(String mess) {
        this.message = mess;
    }

    public String getMessage() {
        return message;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }
    
}

