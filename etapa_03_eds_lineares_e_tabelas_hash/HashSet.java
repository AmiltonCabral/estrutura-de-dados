package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Arrays;
import java.util.Scanner;

public class HashSet {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        TabelaHashEnderecamentoAberto table;
        table = new TabelaHashEnderecamentoAberto(input.nextInt());
        input.nextLine();
        
        while (true) {
            String[] param = input.nextLine().split(" ");
            if (param[0].equals("end")) break;
            
            switch (param[0]) {
                case "put":
                    table.put(Integer.parseInt(param[1]));
                    System.out.println(table);
                    break;
                
                case "remove":
                    table.remove(Integer.parseInt(param[1]));
                    System.out.println(table);
                    break;
                
                case "contains":
                    System.out.println(
                        table.contains(Integer.parseInt(param[1])));
                    break;
            }
        }

        input.close();
    }
}


class TabelaHashEnderecamentoAberto {

    private Num[] tabela;
    private int size;

    public static final int CAPACIDADE_DEFAULT = 20;


    public TabelaHashEnderecamentoAberto() {
        this(CAPACIDADE_DEFAULT);
    }

    
    public TabelaHashEnderecamentoAberto(int capacidade) {
        this.tabela = new Num[capacidade];
        this.size = 0;
    }


    private int hash(Integer chave) {
        return chave % this.tabela.length;
    }


    public boolean contains(int value) {
		boolean contains = false;
		if (!isEmpty()) {
			int i = 0;
			while (i < this.tabela.length - 1 && !contains) {
				int j = this.prob(value, i);
				if (this.tabela[j] != null && !this.tabela[j].isDeleted()) {
					if (this.tabela[j].getValue() == value) {
						contains = true;
					}
				}
				i++;
			}
		}
		return contains;
	}


    
    private boolean isEmpty() {
        return this.size <= 0;
    }


    private int prob(int value, int i) {
		return (value + i) % this.tabela.length;
	}


    public void put(Integer valor) {
        if(isFull() || contains(valor)) {
            return;
        }

        int sondagem = 0;
        int hash;
        while (sondagem < this.tabela.length) {

            hash = prob(valor, sondagem);
            Num tmpNum = this.tabela[hash];
            if (tmpNum == null || tmpNum.isDeleted()) {
                this.tabela[hash] = new Num(valor);
                this.size ++;
                return;
            }

            sondagem ++;

        }

    }


    
    public Num remove(int chave) {
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
                hash = (hash(chave) + sondagem) % tabela.length;

            if (tabela[hash] != null && tabela[hash].getValue().equals(chave)) {
                Num aluno = tabela[hash];  
                tabela[hash].delete();
                this.size -= 1;
                return aluno;
            } 

            sondagem += 1;

        }

        return null;
    }


    
    public int size() {
        return this.size;
    }


    public boolean isFull() {
        return this.size >= this.tabela.length;
    }


    @Override
	public String toString() {
		return Arrays.toString(this.tabela);
	}

}




class Num {

	private Integer value;
	private boolean deleted;

	public Num(Integer valor) {
		this.value = valor;
		this.deleted = false;
	}

	public void delete() {
		this.deleted = true;
	}

	public boolean isDeleted() {
		return this.deleted;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		String result = null;
		if (!this.deleted) {
			result = this.value + "";
		}
		return result;
	}

}