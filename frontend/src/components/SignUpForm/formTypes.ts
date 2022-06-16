import React from "react";

export default interface FormProps {
  data: FormData;
  handleChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

export interface FormData {
  nome?: string;
  cpf?: string;
  datanascimento?: string;
  email?: string;
  telefone?: string;
  login?: string;
  senha?: string;
  confirm?: string;
}
