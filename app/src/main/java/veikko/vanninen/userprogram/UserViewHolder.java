package veikko.vanninen.userprogram;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView userFullName, userEmail, userDegreeProgram, userDegrees;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userFullName = itemView.findViewById(R.id.txtUserFullName);
        userEmail = itemView.findViewById(R.id.txtUserEmail);
        userDegreeProgram = itemView.findViewById(R.id.txtUserDegreeProgram);
        userDegrees = itemView.findViewById(R.id.txtUserDegrees);
    }

}
