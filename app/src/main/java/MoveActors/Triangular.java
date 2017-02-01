package MoveActors;

import static java.lang.Math.sqrt;

/**
 * Created by Michael on 1/31/2017.
 *
 * (Technically, this is the series of triangular numbers + 1, or the Central Polygonal Numbers.)
 * @see <a href="https://oeis.org/A000217">Triangular Numbers</a>
 * @see <a href="https://en.wikipedia.org/wiki/Triangular_number">Wikipedia on Triangular Numbers</a>
 * @see <a href="https://oeis.org/A000124">Central Polygonal Numbers</a>
 * @see <a href="http://stackoverflow.com/questions/2913215/fastest-method-to-define-whether-a-number-is-a-triangular-number">Code for determining if a number is triangular</a>
 */

public class Triangular {
    public boolean checkIfTriangular(int frame){
        // If this formula holds, then this frame is triangular.  See StackOverflow link above
        return int.class.isInstance(sqrt(8 * (frame - 1) + 1));
    }
}
