import java.util.Arrays;

//classe generica que possui como parametro um elemento do tipo T
public class MergeSortGeneric <T extends Comparable<? super T>>{

    public static void main(String[] args){
        // Ordenando String 
        String[] vetorDeStrings = {"Alice", "Luana", "Nelza", "Karen", "Mirian", "Denner", "Ramires", "Neferides", "Tulio", "Demetrice", "Azenate"};
        String[] auxString = new String[vetorDeStrings.length];
        mergeSort(vetorDeStrings, auxString,  0, vetorDeStrings.length - 1);
        System.out.println("Ordenando Strings: " + Arrays.toString(vetorDeStrings));

        // Ordenando Double
        Double[] vetorDeDoubles = {0.35, 0.02, 0.36, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        Double[] auxDouble = new Double[vetorDeDoubles.length];
        mergeSort(vetorDeDoubles, auxDouble, 0, vetorDeDoubles.length - 1);
        System.out.println("Ordenando Doubles: " + Arrays.toString(vetorDeDoubles));
        
        // Ordenando Integer
        Integer[] vetorDeIntegers = {15,2,3,4,55,6,99,44,1,5,7,10};
        Integer[] auxInteger = new Integer[vetorDeIntegers.length];
        mergeSort(vetorDeIntegers, auxInteger, 0, vetorDeIntegers.length - 1);
        System.out.println("Ordenando Integers: " + Arrays.toString(vetorDeIntegers));
    
    }

    // funcao MergerSort
    private static <T extends Comparable<? super T>>  void mergeSort(T[] vetor, T[]auxiliar,  int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim)/2; // ponto médio
            mergeSort(vetor, auxiliar, inicio, meio); // primeira metade
            mergeSort(vetor, auxiliar, meio+1, fim); // segunda metade
            intercalar(vetor, auxiliar, inicio, meio, fim); //junta, comparando os elementos dentro do vetor
        }
    }

    // funcao Intercalar
    private static <T extends Comparable<? super T>> void intercalar(T []vetor, T[]auxiliar, int inicio, int meio, int fim) {
        //percorrendo o vetor principal
        for (int i = inicio; i<=fim; i++){
            auxiliar[i] = vetor[i]; //vetor auxiliar recebe os elementos do vetor principal
        }

        int esq = inicio; //variavel @esq aponta para o primeiro elemento na parte da esquerda do vetor
        int dir = meio + 1; //variavel @dir aponta para o primeiro elemento na parte da direita do vetor
        
        //percorrendo o vetor auxiliar
        for (int i=inicio; i<=fim; i++){
            //vetor auxiliar da esquerda chegar ao final
            if (esq > meio){
                vetor[i] = auxiliar[dir++]; //vetor principal recebe a posicao do auxiliar da direita
            }
            
            //vetor auxiliar da direita chegar ao final 
            else if (dir > fim){
                vetor[i] = auxiliar[esq++]; //vetor principal recebe a posicao do auxiliar da esquerda
            }
            
            //vetor auxiliar da esquerda menor que o da direita
            else if (auxiliar[esq].compareTo(auxiliar[dir]) < 0) { //método compareTo: compara o vetor auxiliar da esquerda com o da direita e retorna os resultados da comparação
                vetor[i] = auxiliar[esq++]; //vetor principal recebe a posicao do auxiliar da esquerda
            }
            
            //vetor auxiliar da esquerda maior que o da direita
            else{
                vetor[i] = auxiliar[dir++];//vetor principal recebe a posicao do auxiliar da direita
            }
        }
    }
    

}
