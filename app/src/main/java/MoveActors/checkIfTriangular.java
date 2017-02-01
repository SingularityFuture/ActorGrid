package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 *
 * (Technically, this is the series of triangular numbers + 1, or the Central Polygonal Numbers.)
 * @see <a href="https://oeis.org/A000217">Triangular Numbers</a>
 * @see <a href="https://en.wikipedia.org/wiki/Triangular_number">Wikipedia on Triangular Numbers</a>
 * @see <a href="https://oeis.org/A000124">Central Polygonal Numbers</a>
 */

public class checkIfTriangular {
    public boolean checkIfTriangular(int frame){
        if(frame==frame*(frame-1)/2+1){ // Formula for triangular numbers
            return true;
        }
        else{
            return false;
        }
    }
}
