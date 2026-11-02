package br.com.padua.handson.exercicio02;

/*
 * EXERCÍCIO 2 · CONSULTÓRIO MÉDICO
 * ASSOCIAÇÃO: a consulta RECEBE um Paciente e um Medico que já existem.
 * Ela guarda a referência (o mesmo objeto), não uma cópia dos dados.
 * Se a consulta for cancelada, paciente e médico continuam existindo.
 */
public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private String dataHora;
    private String status;
    private String observacao;

    public Consulta(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = "AGENDADA";
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void realizar(String observacao) {
        if (!status.equals("AGENDADA")) {
            System.out.println("Não dá para realizar: a consulta está " + status + ".");
            return;
        }
        this.status = "REALIZADA";
        this.observacao = observacao;
        System.out.println("Consulta de " + paciente.getNome() + " realizada.");
    }

    public void cancelar() {
        if (!status.equals("AGENDADA")) {
            System.out.println("Não dá para cancelar: a consulta está " + status + ".");
            return;
        }
        this.status = "CANCELADA";
        System.out.println("Consulta de " + paciente.getNome() + " com "
                + medico.getNome() + " cancelada.");
    }

    public void exibirResumo() {
        System.out.println("Consulta " + dataHora + " | " + paciente.getNome() + " com "
                + medico.getNome() + " (" + medico.getEspecialidade() + ") | " + status);
        if (observacao != null) {
            System.out.println("  Obs.: " + observacao);
        }
    }

    public void enviarLembrete() {
        if (!status.equals("AGENDADA")) {
            System.out.println("Sem lembrete: a consulta está " + status + ".");
            return;
        }
        System.out.println("SMS para " + paciente.getTelefone() + ": "
                + paciente.getNome() + ", consulta com " + medico.getNome()
                + " em " + dataHora + ".");
    }
}
