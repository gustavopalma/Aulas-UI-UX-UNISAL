// Exemplos isolados para demonstração em aula

IconButton(onClick = onDelete) {
    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = stringResource(R.string.cd_delete)
    )
}

Button(onClick = onSave) {
    Icon(Icons.Default.Save, contentDescription = null)
    Text(stringResource(R.string.save))
}

Row(modifier = Modifier.semantics(mergeDescendants = true) { }) {
    Icon(Icons.Default.Wifi, contentDescription = null)
    Text("Wi-Fi")
    Text("Conectado")
}
