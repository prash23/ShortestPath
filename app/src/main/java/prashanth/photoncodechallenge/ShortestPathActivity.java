package prashanth.photoncodechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import prashanth.photoncodechallenge.reusable.LeastMatrix;
import prashanth.photoncodechallenge.services.ShortestPathService;

import static java.lang.String.format;

public class ShortestPathActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userInput;
    private TextView pathCompletedView;
    private TextView totalCost;
    private TextView finalPath;
    private TextView errorField;
    private Button submitBtn;
    private MatrixConversion parseInput;
    private ShortestPathService mShortestPathService;

     String input="8 4 1 3 2 6\n5 9 3 9 9 5\n3 4 1 2 8 6\n6 1 8 2 7 4\n3 7 2 8 6 4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shortest_path);
        userInput = ((EditText) findViewById(R.id.userInput));
        userInput.setText(input);
        pathCompletedView = ((TextView) findViewById(R.id.pathCompleted));
        totalCost = ((TextView) findViewById(R.id.totalCostLabel));
        finalPath = ((TextView) findViewById(R.id.pathOutputLabel));
        errorField = ((TextView) findViewById(R.id.errorLabel));
        submitBtn = (Button) findViewById(R.id.submitBtn);
        parseInput = new MatrixConversion();
        mShortestPathService = new ShortestPathService(new ShortestPath(50));
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.submitBtn:
                try {
                    errorField.setVisibility(View.GONE);
                    pathCompletedView.setVisibility(View.GONE);
                    totalCost.setVisibility(View.GONE);
                    finalPath.setVisibility(View.GONE);
                    LeastMatrix graph = parseInput.parseInput(userInput.getText().toString());
                    displayResults(mShortestPathService.compute(graph));
                } catch (Exception e) {
                    errorField.setVisibility(View.VISIBLE);
                    errorField.setText(e.getMessage());
                }
                break;
            default:
                break;
        }

    }

    private String pathConversation(List<Integer> path) {
        StringBuffer pathprint = new StringBuffer();
        for (int i = 0; i < path.size(); i++) {
            pathprint.append(path.get(i));
            if (i != path.size() - 1) {
                pathprint.append(" ");
            }
        }
        return pathprint.toString();
    }

    private void displayResults(LeastMatrix.Output output) {
        pathCompletedView.setVisibility(View.VISIBLE);
        totalCost.setVisibility(View.VISIBLE);
        finalPath.setVisibility(View.VISIBLE);
        pathCompletedView.setText(output.isFinished() ? "Yes" : "No");
        totalCost.setText(format("%d",output.getCostOfPath()));
        finalPath.setText(pathConversation(output.getPathList()));
    }


    public class MatrixConversion {
        public LeastMatrix parseInput(String input) throws Exception {

            List<String> singleRowAsString  = Arrays.asList(input.split("\n"));
            List<List<Integer>> matrixvalues = new ArrayList<>();

            int minRowSize = 0;
            for (int x = 0; x < singleRowAsString.size(); x++) {
                List<String> stringList = Arrays.asList(singleRowAsString.get(x).split(" +"));

                if (minRowSize == 0)
                    minRowSize = stringList.size();

                if (minRowSize > 10)
                {
                    throw new Exception("Limit for a row is 10 values");
                }
                if (stringList.size() != minRowSize) {
                    throw new Exception("Rows must be same Size");
                }

                List<Integer> rowAsIntegerList = new ArrayList<>();
                for (int i = 0; i < stringList.size(); i++) {
                    try {
                        rowAsIntegerList.add(Integer.parseInt(stringList.get(i)));
                    } catch (Exception e) {
                        throw new Exception("Only Integers are allowed");
                    }
                }
                matrixvalues.add(rowAsIntegerList);
            }

            return new LeastMatrix(matrixvalues);
        }
    }
}
