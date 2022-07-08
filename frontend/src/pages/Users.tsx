import DashboardLayout from "../components/Dashboard/DashboardLayout";
import UsersList from "../components/UsersList";
import PageHeader from "../components/PageHeader";

const Users = () => {
  return (
    <DashboardLayout>
      <PageHeader
        title="Usuários"
        addButtonUrl="/users/adicionar"
        addButtonText="Adicionar Usuário"
      />
      <UsersList users={[{ name: "mateus" }]} />
    </DashboardLayout>
  );
};

export default Users;
