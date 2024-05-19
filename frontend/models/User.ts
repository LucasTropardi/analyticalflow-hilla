import Role from "Frontend/generated/com/ltsoftwaresupport/analyticalflow/model/Role";

export interface User {
    id?: number;
    name: string;
    lastname: string;
    email: string;
    role: Role;
  }