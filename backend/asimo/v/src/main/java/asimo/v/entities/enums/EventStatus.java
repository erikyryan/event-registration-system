package asimo.v.entities.enums;

public enum EventStatus {
    EM_ANDAMENTO(0),
    FINALIZADO(1),
    AGENDADO(2);

    private Integer code;

    EventStatus(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
