package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * ApiSuccessResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

public class ApiSuccessResponse {

    @JsonProperty("responseCode")
    private int responseCode;

    @JsonProperty("message")
    private String message;

    public ApiSuccessResponse(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public ApiSuccessResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ApiSuccessResponse code(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    /**
     * Get responseCode
     *
     * @return responseCode
  *
     */
    @ApiModelProperty(value = "")

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer code) {
        this.responseCode = code;
    }

    public ApiSuccessResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
  *
     */
    @ApiModelProperty(value = "")

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiSuccessResponse apiSuccessResponse = (ApiSuccessResponse) o;
        return Objects.equals(this.responseCode, apiSuccessResponse.responseCode)
                && Objects.equals(this.message, apiSuccessResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseCode, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiSuccessResponse {\n");

        sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
}
