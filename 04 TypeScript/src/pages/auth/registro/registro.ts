import type { IUser } from "../../../types/IUser";
import type { Rol } from "../../../types/Rol";
import { navigate } from "../../../utils/navigate";

const formRegistro = document.getElementById('form-registro') as HTMLFormElement;

if (formRegistro) {
    formRegistro.addEventListener('submit', (e) => {
        e.preventDefault(); 
        
        const emailInput = document.getElementById('registroEmail') as HTMLInputElement;
        const passwordInput = document.getElementById('registroPassword') as HTMLInputElement;
        
        const email = emailInput.value.trim();
        const password = passwordInput.value;

        //Obtiene los usuarios existentes en localStorage o inicializa un array vacío
        const usuariosGuardados = localStorage.getItem('users');
        const listaUsuarios: IUser[] = usuariosGuardados ? JSON.parse(usuariosGuardados) : [];

        //Evita correos duplicados
        const existeUsuario = listaUsuarios.some(user => user.email === email);
        if (existeUsuario) {
            alert('Este correo electrónico ya se encuentra registrado.');
            return;
        }

        //Se crea el nuevo usuario con rol 'client' por defecto y un ID único
        const nuevoUsuario = {
            id: crypto.randomUUID(), 
            email: email,
            password: password,
            role: 'client' as Rol
        }as any;

        //Persistencia de la lista actualizada en localStorage
        listaUsuarios.push(nuevoUsuario);
        localStorage.setItem('users', JSON.stringify(listaUsuarios));

        alert('¡Registro completado con éxito! Ahora podés iniciar sesión.');
        
        //Se redirige automáticamente a la pantalla de Login
        navigate("/src/pages/auth/login/login.html");
    });
}