export interface TableColumn {
  name: string;
  field: string|Function;
  label: string;
  align: "left" | "right";
  format?: Function;
  sort?: Function;
  sortable: boolean;
}