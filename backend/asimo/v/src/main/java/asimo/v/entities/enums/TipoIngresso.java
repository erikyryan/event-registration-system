package asimo.v.entities.enums;

public enum TipoIngresso {
    INTEIRA(0),
    MEIA(1);

    private int code;

    TipoIngresso(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
