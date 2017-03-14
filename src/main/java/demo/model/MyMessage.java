package demo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MyMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
}
