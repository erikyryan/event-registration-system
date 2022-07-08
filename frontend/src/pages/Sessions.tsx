import DashboardLayout from "../components/Dashboard/DashboardLayout";
import PageHeader from "../components/PageHeader";

const Sessions = () => {
  return (
    <DashboardLayout>
      <PageHeader
        title="Sessões"
        addButtonUrl="/sessions/adicionar"
        addButtonText="Adicionar Sessão"
      />
    </DashboardLayout>
  );
};

export default Sessions;
