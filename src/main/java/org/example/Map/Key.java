package org.example.Map;

public class Key {
    private int id;
    private String name;

    @Override
    public int hashCode(){
        int result;
        result = Integer.hashCode(id);
        if(name != null){
            result = 31 * result + name.hashCode();
        } else result = 31 * result; //+ 0
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return  true;
        } else {
            if (obj == null || obj.getClass() != this.getClass()){
                return false;
            } else {
                Key other = (Key) obj;
                if(other.id == this.id){
                    if(name == null && other.name == null){
                        return true;
                    } else{
                        return name != null && name.equals(other.name);
                    }
                } else return false;
            }
        }
    }
}

