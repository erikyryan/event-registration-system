package asimo.v.entities.enums;

public enum TipoVenda {
    PRESENCIAL(0),
    ONLINE(1);

    private Integer code;

    TipoVenda(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
