import "./styles.css";

import icon from "./../../assets/img/notification-icon.svg";
import axios from "axios";
import { BASE_URL } from "../../utils/request";
import { toast } from "react-toastify";

type Props = {
  saleId: number;
};

function handleClick(id: number) {
  axios
    .post(`${BASE_URL}/sale/${id}/notification`)
    .then(() =>
      toast.success("SMS enviado com sucesso!", {
        className: "toast-success",
      })
    )
    .catch(() =>
      toast.error("Erro ao enviar o SMS", {
        className: "toast-error",
      })
    );
}

function NotificationButton({ saleId }: Props) {
  return (
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
      <img src={icon} alt="Notificar" />
    </div>
  );
}

export default NotificationButton;
