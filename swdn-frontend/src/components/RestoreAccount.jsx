export default function RestoreAccount(props) {
    const [email, setEmail] = useState('');

    function restorePerson() {
        const restoredUser = JSON.stringify({
            email: email,
        });
        setEmail('');

        fetch(`http://localhost:8082/api/user/restore/${id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                Authorization:
                    'Basic ' + btoa(props.email + ':' + props.password),
            },
            body: restoredUser,
        }).then(() => props.update());
    }

    return (
        <form
            className="restoreAccount bordered"
            onSubmit={(e) => {
                restorePerson(email);
                e.preventDefault();
            }}
        >
            Restore Account &nbsp;
            <input
                type="email"
                name="email"
                id="email"
                required
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            ></input>
            &nbsp;
            <input
                type="submit"
                value={'Restore'}
            ></input>
        </form>
    );
}
