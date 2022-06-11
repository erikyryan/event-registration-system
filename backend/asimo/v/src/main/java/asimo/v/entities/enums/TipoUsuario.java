package asimo.v.entities.enums;


public enum TipoUsuario {
    USER(0),
    ADMIN(1),
    VENDEDOR(2);

    private int code;

    TipoUsuario(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
