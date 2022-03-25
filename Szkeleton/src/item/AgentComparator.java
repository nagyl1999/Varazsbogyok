package item;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 25.
  @ Author : nagyl

*/

import java.util.Comparator;

/** Ágensek lejárati idő szerinti rendezése */
public class AgentComparator implements Comparator<Agent> {

    /** Ágensek összehasonlítása */
    @Override
    public int compare(Agent o1, Agent o2) {
        return o1.compareTo(o2);
    }

    /** Fordított rendezés */
    @Override
    public Comparator<Agent> reversed() {
        return Comparator.super.reversed();
    }
}
