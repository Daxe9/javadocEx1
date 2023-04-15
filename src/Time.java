/**
 * La classe rappresenta e gestisce dati di tipo temporale
 * 
 * @author Davide Xie
 */
public class Time {
    /**
     * numero di minuti dell'oggetto Time
     */
    protected int minuti;

    /**
     * numero di ore dell'oggetto Time
     */
    protected int ore;

    /**
     * numero di secondi dell'oggetto Time
     */
    protected int secondi;

    /**
     * Costruisce un oggetto Time dato in ingresso il numero di secondi.
     * 
     * Vengono distribuite in automatico i secondi tra le ore, minuti e secondi.
     * Esempio: se in input viene passato 100 allora ora 0, minuti 1 e secondi 40
     * 
     * @param secondi - secondi da assegnare al nuovo oggetto
     */
    public Time(int secondi) {
        addSecondi(secondi);
    }

    /**
     * Costruisce un oggetto Time dato in ingresso ore, minuti e secondi.
     * 
     * Se i parametri di ingresso non sono validi (es. minuti 78) allora l'oggetto
     * Time verrÃ inizializzato con tutti ore, minuti e secondi impostati a 0
     * 
     * @param ore     - ore da assegnare al nuovo oggetto
     * @param minuti  - minuti da assegnare al nuovo oggetto
     * @param secondi - secondi da assegnare al nuovo oggetto
     */
    public Time(int ore, int minuti, int secondi) {
        if (!validTime(ore, minuti, secondi)) {
            this.ore = 0;
            this.minuti = 0;
            this.secondi = 0;
        } else {
            this.ore = ore;
            this.minuti = minuti;
            this.secondi = secondi;
        }
    }

    /**
     * Vengono addizionati il nuero di secondi specificati.
     * 
     * @param secondi - numero di secondi da aggiungere
     */
    public void addSecondi(int secondi) {
        if (secondi > 0) {
            this.secondi += secondi;
            this.minuti += this.secondi / 60;
            this.secondi %= 60;
            this.ore += this.minuti / 60;
            this.minuti %= 60;
        }
    }

    private boolean validTime(int ore, int minuti, int secondi) {
        return !(ore > 24 || ore < 0 || minuti > 60 || minuti < 0 || secondi > 60 || secondi < 0);
    }

    /**
     * Esprime le ore, i minuti e i secondi dell'oggetto Time in secondi. Esempio. 1
     * ora, 20 min, 10 secondi -> 4810s
     * 
     * @return il numero totale dei secondi
     */
    public int convertiSecondi() {
        int result = this.secondi;

        result += this.minuti * 60;

        result += this.ore * 3600;

        return result;
    }

    /**
     * Restituisce il numero di minuti
     * 
     * @return minuti in intero
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * @deprecated
     * @param minuti -
     */
    @Deprecated
    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    /**
     * Restituisce il numero delle ore
     * 
     * @return il numero di ore dell'oggetto Time
     */
    public int getOre() {
        return ore;
    }

    /**
     * @deprecated
     * @param ore -
     */
    @Deprecated
    public void setOre(int ore) {
        this.ore = ore;
    }

    /**
     * Restituisce il numero di secondi
     * 
     * @return il numero di secondi dell'oggetto Time
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * @deprecated
     * @param secondi -
     */
    @Deprecated
    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    /**
     * Restituisce una stringa che rappresenta l'oggetto
     * 
     * @return Rappresentazione testuale dell'oggetto Time {ore:minuti:secondi}
     */
    @Override
    public String toString() {
        return "{" + ore + ":" + minuti + ":" + secondi + "}";
    }
}
