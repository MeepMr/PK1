package DatenhaltungsSchicht;

import FachkonzeptSchicht.Exceptions.PersistenzEcxeption;

import java.util.List;

public interface IDAO {

    void speichern (List<Medium> liste) throws PersistenzEcxeption;
    List<Medium> laden () throws PersistenzEcxeption;
}
