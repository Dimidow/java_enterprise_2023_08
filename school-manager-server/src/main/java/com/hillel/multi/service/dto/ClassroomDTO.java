package com.hillel.multi.service.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

/**
 * Classroom
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-24T22:19:08.376061100+03:00[Europe/Kiev]")
public class ClassroomDTO {

  private Integer classRange;

  private Integer studentsNumber;

  private String classIndex;

  public ClassroomDTO classRange(Integer classRange) {
    this.classRange = classRange;
    return this;
  }

  /**
   * Get classRange
   * @return classRange
  */
  
  @Schema(name = "classRange", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("classRange")
  public Integer getClassRange() {
    return classRange;
  }

  public void setClassRange(Integer classRange) {
    this.classRange = classRange;
  }

  public ClassroomDTO studentsNumber(Integer studentsNumber) {
    this.studentsNumber = studentsNumber;
    return this;
  }

  /**
   * Get studentsNumber
   * @return studentsNumber
  */
  
  @Schema(name = "studentsNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("studentsNumber")
  public Integer getStudentsNumber() {
    return studentsNumber;
  }

  public void setStudentsNumber(Integer studentsNumber) {
    this.studentsNumber = studentsNumber;
  }

  public ClassroomDTO classIndex(String classIndex) {
    this.classIndex = classIndex;
    return this;
  }

  /**
   * Get classIndex
   * @return classIndex
  */
  
  @Schema(name = "classIndex", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("classIndex")
  public String getClassIndex() {
    return classIndex;
  }

  public void setClassIndex(String classIndex) {
    this.classIndex = classIndex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassroomDTO classroomDTO = (ClassroomDTO) o;
    return Objects.equals(this.classRange, classroomDTO.classRange) &&
           Objects.equals(this.studentsNumber, classroomDTO.studentsNumber) &&
           Objects.equals(this.classIndex, classroomDTO.classIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(classRange, studentsNumber, classIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Classroom {\n");
    sb.append("    classRange: ").append(toIndentedString(classRange)).append("\n");
    sb.append("    studentsNumber: ").append(toIndentedString(studentsNumber)).append("\n");
    sb.append("    classIndex: ").append(toIndentedString(classIndex)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

