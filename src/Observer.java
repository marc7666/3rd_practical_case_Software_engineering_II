import java.util.Observable;

/**
 * @project: 3rd practical case Software engineering II.
 * @author: mcr99 on 16/05/2022.
 */
public interface Observer {
    void update(Observable o, Object arg);
}
