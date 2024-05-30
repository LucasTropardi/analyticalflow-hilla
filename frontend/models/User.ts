import Role from "Frontend/generated/com/ltsoftwaresupport/analyticalflow/model/Role";

export interface User {
    email: string;
    name: string;
    lastname: string;
    role: Role;
  }