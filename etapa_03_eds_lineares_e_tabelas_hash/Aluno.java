package etapa_03_eds_lineares_e_tabelas_hash;

import java.util.Objects;

class Aluno {

    private Integer matricula;
    private String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Integer getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
}