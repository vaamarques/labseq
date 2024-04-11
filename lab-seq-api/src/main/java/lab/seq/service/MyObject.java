package lab.seq.service;

import lombok.Data;

import java.util.Objects;

@Data
public class MyObject {

    private String name;
    private Integer age;

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }

        if(getClass() != obj.getClass()){
            return false;
        }
        MyObject anotherObj = (MyObject) obj;

        if(!Objects.equals(this.getAge(), anotherObj.getAge())){
            return false;
        }

        return Objects.equals(this.getName(), anotherObj.getName());
    }
}
