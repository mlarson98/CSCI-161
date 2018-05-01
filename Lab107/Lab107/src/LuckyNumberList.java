import java.util.NoSuchElementException;
/**
 *
 * @author marie
 */
public class LuckyNumberList {
    private LinkedPositionalList<LuckyNumber> luckyList = null;
    
    public LuckyNumberList(){
        this.luckyList = new LinkedPositionalList<>();
    }

    LuckyNumberList(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    LuckyNumberList(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addLuckyNumber(LuckyNumber num){
        luckyList.addLast(num);
    }

    Object positions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class PositionIterator extends Iterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();
        private Position<LuckyNumber> recent = null;
        @Override
        public boolean hasNext(){
            return (cursor != null);
        }
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException{
            if(cursor == null) throw new NoSuchElementException("There isn't anything left");
            recent = cursor;
            cursor = luckyList.after(cursor);
            return recent;
        }
        @Override
        public void remove() throws IllegalStateException{
            if(recent == null) {
                throw new IllegalStateException("There is nothing to remove");
            }
            luckyList.remove(recent); 
            recent = null;
        }
    }   
    private class PositionIterable extends Iterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator(){
            return new PositionIterator();
        }
            
        public Iterable<Position<LuckyNumber>> positions(){
            return new PositionIterable();
        }
            
        private class EvenPositionIterator extends Iterator implements Iterator<Position<LuckyNumber>>{
            private Position<LuckyNumber> cursor = luckyList.first();
            private Position<LuckyNumber> recent = null;
                
        @Override
        public boolean hasNext(){
            return (cursor != null);
        }
                
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException {
            if(recent == null){
                while (cursor != null && !isEven(cursor.getElement().getLuckyNumber()))
                    cursor = luckyList.after(cursor);
            }
                    
            if(cursor == null) {
                throw new NoSuchElementException("no more left");
            }
            recent = cursor;
            cursor = luckyList.after( cursor );
                    
            while(cursor != null && !isEven(cursor.getElement().getLuckyNumber()))
                cursor = luckyList.after(cursor);
                    
            return recent;
        }
                
        @Override
        public void remove() throws IllegalStateException{
            if(recent == null){
                throw new IllegalStateException("nothing left");
            }
            luckyList.remove(recent);
            recent = null;
        }

            private boolean isEven(int luckyNumber) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
    }
    private class EvenpositionIterable extends Iterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator(){
            return new EvenPositionIterator();
        }
    }
    public Iterable<Position<LuckyNumber>> EvenPosition(){
        return new EvenpositionIterable();
    }
    public boolean isPrime(int n){
        return n == 2 || n == 3 || n==5 || n==7;
    }
    private class PrimePositionIterator extends Iterator implements Iterator<Position<LuckyNumber>>{
        private Position<LuckyNumber> cursor = luckyList.first();
        private Position<LuckyNumber> recent = null;
                
        @Override
        public boolean hasNext(){
            return (cursor != null);
        }
                
        @Override
        public Position<LuckyNumber> next() throws NoSuchElementException{
            if(recent == null){
                while(cursor != null && !isPrime(cursor.getElement().getLuckyNumber()))
                    cursor = luckyList.after(cursor);
            }
            if(cursor == null){
                throw new NoSuchElementException("There isn't anything left");
            }
            recent = cursor;
            cursor = luckyList.after(cursor);
                    
            while(cursor != null && !isPrime(cursor.getElement().getLuckyNumber()))
                cursor = luckyList.after(cursor);
                    
            return recent;
        }
               
        @Override
        public void remove() throws IllegalStateException{
            if(recent == null) throw new IllegalStateException("There is nothing to remove");
            luckyList.remove(recent);
            recent = null;
        }
    }
    private class PrimeIterable extends Iterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator(){
            return new PrimePositionIterator();
        }
    }
    public Iterable<Position<LuckyNumber>> primePosition(){
        return new PrimeIterable();
    }
            
    @Override
    public String toString(){
        String returnString = "";
                
        Iterator<LuckyNumber> listIterator = luckyList.iterator();
                
        while(listIterator.hasNext())
            returnString += listIterator.next() + "";
        return returnString;
        }
    }
    
}
