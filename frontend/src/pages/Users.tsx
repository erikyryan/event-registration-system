import DashboardLayout from "../components/Dashboard/DashboardLayout";
import UsersList from "../components/UsersList";
import PageHeader from "../components/PageHeader";
import { IUser } from "../types/IUser";
import { useAuth } from "../contexts/AuthContext";
import api from "../services/api";
import { useEffect, useState } from "react";

const Users = () => {
  const { token } = useAuth();
  const [users, setUsers] = useState<IUser[] | null>(null);

  const fetchUsers = async () => {
    if (!token) return;
    try {
      const { data } = await api.get("/user/listAll", {
        headers: {
          token
        }
      });
      setUsers(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  return (
    <DashboardLayout>
      <PageHeader
        title="Usuários"
        addButtonUrl="/users/adicionar"
        addButtonText="Adicionar Usuário"
      />
      <UsersList users={users} />
    </DashboardLayout>
  );
};

export default Users;
