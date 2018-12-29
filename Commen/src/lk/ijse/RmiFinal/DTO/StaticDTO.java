package lk.ijse.RmiFinal.DTO;

public class StaticDTO {
    private static int ids;

    public StaticDTO() {
    }

    public static int getIds() {
        return ids;
    }

    public static void setIds(int ids) {
        StaticDTO.ids = ids;
    }
}
