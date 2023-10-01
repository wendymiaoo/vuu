import { TableCellProps } from "@finos/vuu-datagrid-types";
import { registerComponent } from "@finos/vuu-utils";

import "./SearchCell.css";

const classBase = "vuuSearchCell";

// export to avoid tree shaking, component is not consumed directly
export const SearchCell = ({ column, row }: TableCellProps) => {
  //TODO what about click handling

  const { key } = column;
  const value = row[key];

  return (
    <div className={classBase} tabIndex={-1}>
      <span data-icon="draggable" />
      {value}
    </div>
  );
};

console.log("register SearchCell");

registerComponent("search-cell", SearchCell, "cell-renderer", {
  serverDataType: "private",
});