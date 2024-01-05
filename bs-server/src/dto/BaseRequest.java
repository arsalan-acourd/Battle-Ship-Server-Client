package dto;

import java.io.Serializable;

public class BaseRequest implements Serializable {

  public String type;
  public Serializable value;

  public BaseRequest(String type, Serializable value) {
    this.type = type;
    this.value = value;
  }

  public BaseRequest(String type) {
    this.type = type;
  }
}
