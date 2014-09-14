package be.rd.structures.hashcollections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruben on 8/17/14.
 */
public class MissingHashCode {

    public static void main(String[] args){
        new MissingHashCode().test();
    }

    public static class PhoneNrBad {
        private int zoneNr;
        private int nr;

        public PhoneNrBad(int zoneNr, int nr){
            this.zoneNr = zoneNr;
            this.nr = nr;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if(obj instanceof PhoneNrBad){
                PhoneNrBad tmp = (PhoneNrBad)obj;
                return this.zoneNr == tmp.getZoneNr() && this.nr == tmp.getNr();
            }
            return false;
        }

        public int getZoneNr() {
            return zoneNr;
        }

        public int getNr() {
            return nr;
        }
    }

    public static class PhoneNrGood extends PhoneNrBad{

        public PhoneNrGood(int zoneNr, int nr) {
            super(zoneNr, nr);
        }

        @Override
        public int hashCode() {
            String tmp = String.valueOf(getZoneNr()) + String.valueOf(getNr());
            return Integer.parseInt(tmp);
        }
    }

    /**
     * Shows what can happen when you override equals
     * but do not override hashcode accordingly!!
     * In this example the hasSet could contain duplicate elements!
     */
    public void test(){
        PhoneNrBad nr1 = new PhoneNrBad(56, 776650);
        PhoneNrBad nr2 = new PhoneNrBad(56, 776650);
        System.out.println(nr1.equals(nr2));
        Set<PhoneNrBad> nrs = new HashSet<PhoneNrBad>();
        nrs.add(nr1);
        nrs.add(nr2);
        System.out.println("Nr of elements : " + nrs.size());


        PhoneNrGood nr3 = new PhoneNrGood(56, 776650);
        PhoneNrGood nr4 = new PhoneNrGood(56, 776650);
        System.out.println(nr3.equals(nr4));
        Set<PhoneNrGood> otherNrs = new HashSet<PhoneNrGood>();
        otherNrs.add(nr3);
        otherNrs.add(nr4);
        System.out.println("Nr of elements : " + otherNrs.size());
    }
}
